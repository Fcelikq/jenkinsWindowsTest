# jenkinsWindowsTest

WinAppDriver is a open source tool to automate Window based application

Youtube Tutorial:
https://www.youtube.com/watch?v=Q_HUkWczd34&list=PLEiBaBxmVLi9-Ioe2lys5xpR4S4fUOq7F


# Basic Requirement:
Window 10 or above
Java 8 or above
Admin rights on system
Developer mode should be on | Settings > For developers
Java, Maven
* Windows Kits    |   https://developer.microsoft.com/en-us/windows/downloads/windows-10-sdk
* WinAppDriver    |   https://github.com/Microsoft/WinAppDriver/releases


# Steps:
1. Double click WinAppDriver.exe located at C:\Program Files (x86)\Windows Application Driver

# How to find locators
Double click inspect.exe
Path:
* C:\Program Files (x86)\Windows Kits\10\bin\10.0.16299.0\x64
* C:\Program Files (x86)\Windows Kits\10\bin\10.0.16299.0\x86

# Useful links:
https://github.com/Microsoft/WinAppDriver/tree/master/Tests/UWPControls
https://github.com/Microsoft/WinAppDriver/tree/master/Tests/WebDriverAPI
https://github.com/Microsoft/WinAppDriver/issues/165
https://github.com/Microsoft/WinAppDriver/issues/240
https://github.com/Microsoft/WinAppDriver/issues
window 10 sdk | https://developer.microsoft.com/en-us/windows/downloads/windows-10-sdk


# Locator mapping to methods
* findElementByAccessibilityId    AutomationId
* findElementByName               Name
* findElementById                 RuntimeId (decimal)
* findElementByClassName          ClassName
* findElementByTagName            LocalizedControlType (upper camel case)
