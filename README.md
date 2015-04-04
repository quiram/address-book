# Build
`mvn verify`

# Run
`cd target`  
`java -jar address-book-1.0-jar-with-dependencies.jar`


# Design Notes
Tests for DataLoader are considered integration tests because they load files from the file system, which rules them out as unit tests.

Main App isn't tested, it is considered to be simple enough so it doesn't need testing. Everything else is appropriately tested.