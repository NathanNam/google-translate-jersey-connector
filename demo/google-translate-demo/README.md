Google Translate Connector Demo Application
===================================

Description:
Based on the user URL input this demo application performs the following -

* /gettranslate - Returns a translated text (less than 2K characters) in a language you specified in Target Language.
* /posttranslate - Returns a translated text (less than 5K characters) in a language you specified in Target Language.
* /getsupportedlanguages - Returns a list of supported languages by Google Translate.
* /getdetectlanguage - Returns a detected language in which a given text (less than 2K characters) is written.
* /postdetectlanguage- Returns a detected language in which a given text (less than 5K characters) is written.


To be able to successfully run this application, Google Translate API Key should be configured in this application.

Usage:
Once mule is up and running, you must call http://localhost:8081/{operation} to perform one of the five operation described above. For example, if you want to launch the gettranslate operation, you can call http://localhost:8081/gettranslate.
