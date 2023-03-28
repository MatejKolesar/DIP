!#/bin/bash

set -B                  # enable brace expansion
for i in {1..100}; do
  curl   'localhost:8082/load/memoryTest'
  echo 'Send ' +$i;
done

