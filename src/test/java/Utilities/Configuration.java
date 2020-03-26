package Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

public class Configuration {

    private static Configuration instance;
    private Properties configProps = new Properties();


    private String Email;
    private String Password;




    public static Configuration getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    private static synchronized void createInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
    }

    private Configuration() {

        InputStream is = null;
        try {
            is = ClassLoader.getSystemResourceAsStream("test_config.property");
            Reader reader = new InputStreamReader(is, "UTF-8");
            configProps.load(reader);

            this.Email = configProps.getProperty("email");
            this.Password = configProps.getProperty("password");

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public String getEmail() { return Email; }

    public String getPassword() { return Password; }


}
