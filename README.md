# Mojarra 4145

This repo contains a small reproducer for Mojarra issue [4145](https://github.com/eclipse-ee4j/mojarra/issues/4145) and
its followups (e.g. [5036](https://github.com/eclipse-ee4j/mojarra/issues/5036)).

# Steps

* Build using `mvn package`
* Deploy the `target/mojarra4145.war` to WildFly 26.0.0.Final
* Open a browser on http://localhost:8080/mojarra4145/
  * Hint: Open your browser's developer tools now
* Switch to tab "Invalid Char Demo"
* Add an invalid entry using the "Add invalid entry" button
  * Look at the browser's developer tools - you should already see some error regarding invalid XML
  * Notice how no entry appears in the list
* Open another a second browser window, open http://localhost:8080/mojarra4145/, and go to tab "Invalid Char Demo"
  * Notice how the tab is completely empty
* Switch back to "Dummy" tab and click "Remove invalid entry"
* Everything is back to normal now in both browser windows
