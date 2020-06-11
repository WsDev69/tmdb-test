#!/usr/bin/env bash

java  -Xss1M -Xmx261240K -jar target/`ls ./target | grep \.jar | grep -v original | grep -v javadoc | grep -v sources`