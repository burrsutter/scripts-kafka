#!/bin/bash

oc extract secret/burr-cluster-cluster-ca-cert --keys=ca.crt --to=- > ca.crt