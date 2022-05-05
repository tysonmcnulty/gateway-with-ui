# Gateway with UI

This project shows how to stand up a UI application (built with the Angular framework) behind an API gateway (built with Spring Cloud Gateway).

## Development

There is a Gradle wrapper script, `gradlew`, at the root of this project. There are two subprojects, `gateway` and `ui`, included in the root Gradle project.

There are two tasks, `build` and `run`, defined in the root project. These are exclusively for ease of development.

```shell
./gradlew build             # build both apps
./gradlew :gateway:build    # build just the gateway
./gradlew :ui:build         # build just the UI

./gradlew run               # run both apps
./gradlew :gateway:bootRun  # run just the gateway
./gradlew :ui:serve         # run just the UI
```

## Deployment

As a prerequisite, install the CF cli:

```shell
# Example using Homebrew
brew install cloudfoundry/tap/cf-cli
```

There is a TAS manifest, `manifest.yml`, at the root of this project. To push the app to TAS using this manifest:

1. Define a `vars.yml` that specifies the variables required for remote deployment.

   ```yaml
   cat > vars.yml <<EOF
   ---
   GATEWAY_ROUTE: my-gateway.apps.example.com
   UI_ROUTE: my-ui.apps.example.com
   EOF
   ```

   Replace the values in the preceding snippet with values that make sense for your deployment.

2. Push to TAS using the `--vars-file` parameter.

   ```
   cf push --vars-file vars.yml
   ```
