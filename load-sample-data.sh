#!/bin/bash
mongoimport --uri mongodb+srv://ashishjha80:ashishsasa@buildout-qa.z4ij7.mongodb.net/quiz --collection modulequestions --type json --drop --jsonArray --file initial_data_load.json