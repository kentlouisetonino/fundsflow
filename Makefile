build:
	gcc -g -o bin/fundsflow src/main.c

fundsflow:
	make build
	bin/fundsflow

debug:
	make build
	gdb bin/fundsflow
