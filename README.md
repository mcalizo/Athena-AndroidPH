# athena-androidph 2.0 (Page-Object-Model)
### Pre-requisite/s software installed
1. Git
2. Eclipse
3. Docker

### Athena installation Steps
1. Clone athena repo to your home directory: <br>
```$ git clone https://github.com/athena-oss/athena.git``` <br>
``` - go to athena root dir using terminal (ex. cd athena/)``` <br>
``` execute ./athena init ``` <br>
``` - Follow the ATHENA instruction to make ATHENA global``` <br>
``` - Restart your terminal ``` <br>
<b>OR Add following to bash_profile</b><br>
```a. $ vi ~/.bash_profile``` (Mac User) , ```vi ~/.bashrc``` (Linux User) <br>
```b. add the following at the end of line``` <br>
      ```export ATHENA_HOME=/<installation location>/athena``` <br>
      ```export PATH=${PATH}:$ATHENA_HOME```
2. execute again ```$ athena init``` under athena project to check if athena is properly installed
3. Install the following plugin/s under athena project directory <br>
<b>SELENIUM:</b> ```$ athena plugins install selenium https://github.com/athena-oss/plugin-selenium.git```<br>
<b>APPIUM:</b> ```$ athena plugins install appium https://github.com/athena-oss/plugin-appium.git```<br>

### Android Studio
1. Download and install Android Studio
2. Configure ANDROID_HOME in ```~/.bash_profile``` (OSx User), ```~/.bashrc``` (Linux User)
```
example:
export ANDROID_HOME=/Users/mcgagan/android-sdks
export PATH=${PATH}:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools:$ANDROID_HOME/build-tools 
```

### Virtual Box
1. Download and install virtual box
 - For linux user just execute ```sudo apt-get install virtualbox```
 - For Mac user download to this <b><a href="https://www.virtualbox.org/wiki/Downloads">link</a></b> and install

### Genymotion
1. Install Genymotion and configure Android SDK path

### Android Project Checkout and Import steps (Eclipse)
1. Clone <b>athena-androidph2.0</b> to your root directory <br>
```$ git clone https://github.com/mcalizo/Athena-AndroidPH```
2. Using eclipse IDE, right click on <b>Project Explorer</b>
3. Select <b>Import</b>
4. Expand <b>Maven</b> and select <b>Existing Maven Projects</b>
5. Click <b>Next</b> and browse the Root Directory (athen-androidph2.0)
6. Click <b>Next</b> to complete import steps

### Starting Selenium Hub and Appium Node/s
1. Start Genymotion Device with the following details: <br>
- <b>Device 1</b> ``` : Samsung Galaxy S5 - Android 4.4.4 - API 19 ``` <br>
- <b>Device 2</b> ``` : Samsung Galaxy S6 - Android 5.0.0 - API 21 ``` <br>
- <b>Device 3</b> ``` : Samsung Galaxy S7 - Android 6.0.0 - API 23 ``` <br>
2. Selenium Hub: ``` athena selenium start hub <version> ``` <br>
``` Note: Use ```<b>3.1</b>``` selenium hub version```
3. Appium Node/s: (Replace <b>AVD IP</b> with device ip from Genymotion)<br>
- ``` Open terminal and go to ```athena-androiph2.0``` project directory ``` <br>
- Execute : ``` athena appium start --apks-dir=apps --with-avd=AVD IP:5555 --port=4725 --adb-port=5035 --link-hub=athena-selenium-0-hub --nodeconfig=./athena_node_config_p4725.json ``` <br>
- Execute : ``` athena appium start --apks-dir=apps --with-avd=AVD IP:5555 --port=4728 --adb-port=5038 --link-hub=athena-selenium-0-hub --nodeconfig=./athena_node_config_p4728.json ``` <br>
- Execute : ``` athena appium start --apks-dir=apps --with-avd=AVD IP:5555 --port=4731 --adb-port=5041 --link-hub=athena-selenium-0-hub --nodeconfig=./athena_node_config_p4731.json ``` <br>

### Running Test
1. Open terminal and go to ```athena-androiph2.0``` project directory
2. Execute below commands in terminal <br>

- ```athena appium java java clean test``` (to run the test)
- ```athena appium java java site``` (to generate good looking allure report)
3. Refresh the project in eclipse. Under "target" folder you should see the "site" folder where allure report is generated

### Installing Google Play Services to enable Marketplace
1. Dowload the files
<li><b>Download the flashable zip of gapps for 4.4.*</b> - <a href="https://app.box.com/s/o2pamfphxal19qa77bhejpr5ldn35ynr">Download Now!</a> <br>
<li><b>Download Arm Translation Installer v1.1</b> - <a href="https://app.box.com/s/wmz6emtsqh41qs01hxg3sj6uqqp0ltwr">Download Now!</a> <br>

2. Follow instruction on this link <a href="http://www.downloadorinstall.com/arm-translation-installer-genymotion/">Link</a>

### Troubleshooting & FAQ
1. Unable to run test, ERRORS displaying when executing the test
- There are only one posible cause and this is you do not have successfully connected your AVD in selenium hub server <br>
<b>Solution/s:</b><br>
<b>Options 1</b> : By connecting manually your device via athena appium node terminal. See below. <br>  
- at terminal execute commands <br>
```athena appium --port=4725 terminal``` <br>
```adb connect <AVD IP:5555>``` <br>
- Execute same step in other athena appium node. <br>
- Run the test again, and you should able to run the test <br>
<b>Options 2</b> : Removed the path of Android SDK Genymotion ADB configuration and restarting the device <br>
- Close all your open device/s <br>
- In your Genymotion, removed the ADB path in settings to ensure is will not automatically connect the device in local adb <br>
- Start again the devices and Start the APPIUM NODES <br>
- Run the test again, and you should able to run the test <br>


2. How to check appium logs?
```
At terminal execute the following commands
 - athena appium --port=<PORT> logs
```

3. How to check selenium hub logs
```
At terminal execute the following commands
 - athena selenium hub logs
```

4. Can I still run test individually using the parallel setup? Answer: Yes, just comment out test classes in testng.xml. <br>

5. How to update version of installed app in Genymotion device recursively

```
At terminal execute the following commands
- athena appium exec --port=<Athena Appium Node PORT Number> adb install -r "/opt/apks/android/OLXPH-AutoTest.apk"
- Example : athena appium exec --port=4725 adb install -r "/opt/apks/android/OLXPH-AutoTest.apk"
```

###Misc for reference only (Nothing to do with the test):
```
java -jar *.jar -role hub -hubConfig hub_config.json -debug

node --max_old_space_size=5120 /usr/local/lib/node_modules/appium/build/lib/main.js --session-override --nodeconfig node_config2.json -p 4725 -bp 5725 -U 192.168.57.101:5555

node --max_old_space_size=5120 /usr/local/lib/node_modules/appium/build/lib/main.js --session-override --nodeconfig node_config.json -p 4727 -bp 5727 -U 192.168.57.103:5555

cd athena-androidph2.0
node --max_old_space_size=5120 /usr/local/lib/node_modules/appium/build/lib/main.js --session-override --nodeconfig node_config2.json -p 4725 -bp 5725 --default-capabilities '{"udid":"192.168.57.103:5555"}'
cd athena-androidph2.0
node --max_old_space_size=5120 /usr/local/lib/node_modules/appium/build/lib/main.js --session-override --nodeconfig node_config.json -p 4727 -bp 5727 --default-capabilities '{"udid":"192.168.57.101:5555"}'

```
Starting Appium Nodes for parallel testing
```
athena selenium start hub <version>
athena appium start --apks-dir=apps --with-avd=192.168.57.101:5555 --port=4725 --adb-port=5035 --link-hub=athena-selenium-0-hub --nodeconfig=./athena_node_config_p4725.json
athena appium start --apks-dir=apps --with-avd=192.168.57.102:5555 --port=4728 --adb-port=5038 --link-hub=athena-selenium-0-hub --nodeconfig=./athena_node_config_p4728.json
athena appium start --apks-dir=apps --with-avd=192.168.57.103:5555 --port=4731 --adb-port=5041 --link-hub=athena-selenium-0-hub --nodeconfig=./athena_node_config_p4731.json

```

  
```
