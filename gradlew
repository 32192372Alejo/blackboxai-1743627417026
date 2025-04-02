#!/bin/sh
set -e

DIR="$(cd "$(dirname "$0")" && pwd)"
EXEC="$DIR/gradle/wrapper/gradle-wrapper.jar"

if [ ! -f "$EXEC" ]; then
    echo "Gradle wrapper jar not found. Please run 'gradle wrapper' to generate it."
    exit 1
fi

exec java -jar "$EXEC" "$@"