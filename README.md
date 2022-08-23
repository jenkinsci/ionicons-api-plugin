IoniconsAPI plugin
==============================
[![Build Status](https://ci.jenkins.io/buildStatus/icon?job=Plugins/ionicons-api-plugin/main)](https://ci.jenkins.io/job/plugins/job/ionicons-api-plugin/)
[![Gitter](https://badges.gitter.im/jenkinsci/ux-sig.svg)](https://gitter.im/jenkinsci/ux-sig?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)
[![Jenkins Plugin](https://img.shields.io/jenkins/plugin/v/ionicons-api.svg)](https://plugins.jenkins.io/ionicons-api-plugin/)
[![Jenkins Plugin Installs](https://img.shields.io/jenkins/plugin/i/ionicons-api.svg?color=blue)](https://plugins.jenkins.io/ionicons-api/)
[![Contributors](https://img.shields.io/github/contributors/jenkinsci/ionicons-api-plugin.svg)](https://github.com/jenkinsci/ionicons-api-plugin/graphs/contributors)

## Usage

This plugin provides [ionicons](https://ionic.io/ionicons), also known as "symbols", for your Jenkins plugins.

Add the ionicons-api as dependency to your `pom.xml`:

See the [plugin site](https://plugins.jenkins.io/ionicons-api/#dependencies) for a snippet.

To use a symbol, reference the icon as following:

### Jelly
```xml
<l:icon src="symbol-symbolName-outline plugin-ionicons-api" />
```

### Groovy
```groovy
l.icon(src:"symbol-symbolName-outline plugin-ionicons-api")
```

### Java

```java
@Override
public String getIconClassName() {
    return "symbol-symbolName-outline plugin-ionicons-api";
}
```

Preferably, use symbols containing `-outline`, if available, they fit the best in the Jenkins UI and are used in the Jenkins plugin ecosystem.

A list of all symbols is available on [the Ionicons website](https://ionic.io/ionicons).

More information about symbols and themes in Jenkins can be found [here](https://weekly.ci.jenkins.io/design-library/Symbols/).

If an icon is not theme-able, please raise an [issue](https://github.com/jenkinsci/ionicons-api-plugin/issues/new/choose).
