# Vlending AppLink for AOS
Distribute the SDK of the deep link service provided by Vlending.

## Requirements
* Android 7.0+
* Android Studio 3.0+
* Java 7+

## Features

Provides the following features:
* Shortened URL
* Apple
    * [Universal Links](https://developer.apple.com/ios/universal-links/)
    * [Custom URL scheme](https://developer.apple.com/documentation/xcode/defining-a-custom-url-scheme-for-your-app)
* Android
    * [App Links & Custom URL scheme](https://developer.android.com/training/app-links)
    * [Intent scheme](https://developer.chrome.com/docs/android/intents)
* Link's preview webpage and OGTAG
* Webpage for management

Analysis functions will also be provided in the future.

To use the above functions, you must obtain a subdomain and API key.
Learn more about the provided documentation, integrating the SDK into your app, and more at [here](https://www.notion.so/vlending/Vlending-AppLink-Docs-42018af2e9bf46a6af73e9bbf76c18c9)

## Installation

### Android Package Manager

use Gradle:
```gradle
repositories {
  google()
  mavenCentral()
}

dependencies {
  implementation 'io.github.vlending-dev.applink-android-sdk:0.0.22'
}
```

Or Maven:

```xml
<dependency>
  <groupId>io.github.vlending-dev</groupId>
  <artifactId>applink-android-sdk</artifactId>
  <version>0.0.22</version>
</dependency>
```

## License

See the [LICENSE](https://github.com/vlending-dev/applink-android-sdk/blob/master/LICENSE) file.
Copyright © Vlending Co., Ltd.

## Contact

For usage and development inquiries, please contact [here](mailto:applink@vlending.co.kr).