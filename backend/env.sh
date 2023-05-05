#!/usr/bin/env bash

# shellcheck disable=SC2046
export $(cat .env | xargs)
