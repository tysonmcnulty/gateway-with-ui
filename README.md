# Gateway with UI

This project shows how to stand up a UI application (built with the Angular framework) behind an API gateway (built with Spring Cloud Gateway).

## Development

There is a Gradle wrapper script, `gradlew`, at the root of this project. You can use it to run Gradle tasks in the subprojects.

There are two subprojects, `gateway` and `ui`.

```shell
./gradlew build             # run `build` in all subprojects
./gradlew :gateway:build    # run `build` in the gateway subproject only
./gradlew :ui:build         # run `build` in the ui subproject only
```

## Deployment

As a prerequisite, install the CF cli:

```shell
# Example using Homebrew
brew install cloudfoundry/tap/cf-cli
```

There is a TAS manifest, `manifest.yml`, at the root of this project. 

```
export TAS_APP_DOMAIN=apps.dhaka.cf-app.com
export GATEWAY_HOSTNAME=my-gateway
export UI_HOSTNAME=my-ui
cf push
```
