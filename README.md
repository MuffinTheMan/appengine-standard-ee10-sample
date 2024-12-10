## App Engine Runtime

Replace `runtime-*.jar` files in `default/src/main/webapp` with actual jars (these are currently empty placeholder files, since the actual files are large and impractical to include in the project). If you want to use Google's runtime, there's no need to replace these jars; instead, remove the `<endpoint>` block from `default/src/main/webapp/WEB-INF/appengine-web.xml`.

## Deploying

Via commandline, deploy to an existing Appengine Standard project like so (replace `APPENGINE_PROJECT_ID_HERE` and `VERSION_NUM_HERE` with the ProjectID for the Appengine project and whatever Version you want):

```
./gradlew ciDeployAllModules '-PprojectId=APPENGINE_PROJECT_ID_HERE' '-PversionNum=VERSION_NUM_HERE'
```

## Issues

> Tested with Google Cloud SDK version `502.0.0`.

In addition to the cloud Appengine runtime being apparently broken, the most aggravating issue is the differences between how the local development appengine application runs vs how the deployed application runs. Example(s):

### Broken

* Navigate to `/redirect-test`
    * Local App: redirected to `/jsp`
    * Deployed App: the browser displays an error like `Request failed: Unexpected Error: java.io.IOException: written 2 > 0 content-length`