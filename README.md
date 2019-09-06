# TestAppium

## Steps to execute
1. Start Appium server manually in terminal using `appium`
2. Start an Android emulator using Android studio and confirm device connection using `adb devices` command
3. In the emulator bring the app under test in the focus and then run command `adb shell dumpsys window windows |grep mCurrentFocus` to get the app package and app activity of the app
4. Open another terminal and navigate to the project
5. Run command `mvn clean test` 
