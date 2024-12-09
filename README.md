## App Engine Runtime

Replace `runtime-*.jar` files in `default/src/main/webapp` with actual jars (these are currently empty placeholder files, since the actual files are large and impractical to include in the project). If you want to use Google's runtime, there's no need to replace these jars; instead, remove the `<endpoint>` block from `default/src/main/webapp/WEB-INF/appengine-web.xml`.

## Deploying

Via commandline, deploy to an existing Appengine Standard project like so (replace `APPENGINE_PROJECT_ID_HERE` and `VERSION_NUM_HERE` with the ProjectID for the Appengine project and whatever Version you want):

```
./gradlew ciDeployAllModules '-PprojectId=APPENGINE_PROJECT_ID_HERE' '-PversionNum=VERSION_NUM_HERE'
```

## Issues

> Tested with Google Cloud SDK version `502.0.0`.

In addition to the cloud Appengine runtime being apparently broken, the most aggravating issue is the differences between how the local development appengine application runs vs how the deployed application runs. Here are some examples:

### Broken

* Navigate to `/sdfsdf`
    * Local App: the `404.html` page is rendered
    * Deployed App: the browser hangs and never receives a response from the server
* Navigate to `/send-error?errorCode=500`
    * Local App: the `500.html` page is rendered
    * Deployed App: the browser hangs and never receives a response from the server
* Navigate to `/send-error?errorCode=404`
    * Local App: the `404.html` page is rendered
    * Deployed App: the browser hangs and never receives a response from the server
* Navigate to `/send-error?errorCode=0` or `/send-error`
    * Local App: the `hello.html` page is rendered
    * Deployed App: the browser hangs and never receives a response from the server
* Navigate to `/send-error?errorCode=` or `/send-error?errorCode=-1` or `/send-error?errorCode=sdf`
    * Local App: the `unhandled-error.html` page is rendered
    * Deployed App: the browser hangs and never receives a response from the server
* Navigate to `/jsp`
    * Local App: the `test.jsp` page is rendered
    * Deployed App: the browser hangs and never receives a response from the server
* Navigate to `/jsp?fail=true`
    * Local App: the `unhandled-error.html` page is rendered
    * Deployed App: the browser hangs and never receives a response from the server (and the `About to fail.` log never appears)

### Working

* Navigate to `/404.html`
    * Local App: the `404.html` page is rendered
    * Deployed App: the `404.html` page is rendered
* Navigate to `/unhandled-error.html`
    * Local App: the `unhandled-error.html` page is rendered
    * Deployed App: the `unhandled-error.html` page is rendered
* ...etc (basically, directly navigating to static files works as expected)