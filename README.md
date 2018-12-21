# Android MVP boilerplate template

### Project Created by references :
https://proandroiddev.com/dagger-2-annotations-binds-contributesandroidinjector-a09e6a57758f
https://github.com/ragdroid/Dahaka
https://github.com/googlesamples/android-architecture/tree/todo-mvp-dagger
https://github.com/MindorksOpenSource/android-mvp-architecture


## Requirements

  * Android Studio v3.1.4 or higher is required
  * JDK 1.8
  * Android SDK
  * Android API 27
  * Latest Android SDK Tools and build tools.

## Code Analysis tools (optional)

This will run all the code analysis tools in the following order:

![](https://gitlab.ainosi.co.id/custom-payment-integration/eret-pasar-semarang/android-eretribusi/raw/master/check.png)

The following code analysis tools are set up on this project:

before that, rebuild the project first

[Checkstyle](http://checkstyle.sourceforge.net/): It ensures that the code style follows [our Android code guidelines](https://github.com/ribot/android-guidelines/blob/master/project_and_code_guidelines.md#2-code-guidelines).

```
./gradlew checkstyle
```

[Findbugs](http://findbugs.sourceforge.net/): This tool uses static analysis to find bugs in Java code. Unlike PMD, it uses compiled Java bytecode instead of source code.

```
./gradlew findbugs
```

[PMD](https://pmd.github.io/): It finds common programming flaws like unused variables, empty catch blocks, unnecessary object creation, and so forth.

```
./gradlew pmd
```

## The check task

To ensure that your code is valid and stable use check (Android lint):

```
./gradlew check
```