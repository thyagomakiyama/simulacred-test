#!/bin/bash

echo "Building Core module..."
./gradlew :core:clean :core:build

CORE_JAR_PATH="./core/build/libs/core-0.0.1-SNAPSHOT.jar"
if [ ! -f "$CORE_JAR_PATH" ]; then
    echo "Core JAR not found. Exiting."
    exit 1
fi

echo "Building API module..."
./gradlew :api:clean :api:build

echo "Both modules built successfully."