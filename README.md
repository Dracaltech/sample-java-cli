# sample-java-cli
Dracal // SDK code sample for Java on CLI


## Assumptions

Running this repository requires you to have installed:
- Java (version >= 11)
- Gradle (version >= 6.7)
- DracalView (version >= `3.2.x`)
  - Specifically, `dracal-usb-get` needs to be accessible from your `PATH` environment variable (more info in the [documentation how-to](https://www.dracal.com/en/programmers_howto/#dracal-usb-get)).

Script may need to be adjusted depending on your instrument's # of outputs _(currently assumed: 3 outputs)_. See script comments for details.

You can test your setup by executing a build:
```
gradle build
```

## Simple usage

Run script
```
gradle execute
```

## Sample output
<img src="https://github.com/Dracaltech/sample-java-cli/assets/1357711/3111b37e-bc91-4832-bf31-fcf595ce127b" width=400 />

```
Ξ dracal/sample-java-cli git:(main) ▶ gradle execute

> Task :execute
Temperature (C):100.22
RH......... (%):24.34
Pressure..(kPa):51.06
Temperature (C):212.396

BUILD SUCCESSFUL in 1s
2 actionable tasks: 1 executed, 1 up-to-date
Ξ dracal/sample-java-cli git:(main) ▶
```
