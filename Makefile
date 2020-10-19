# Ensimag 2A POO - TP 2015/16
# ============================
#
# Ce Makefile permet de compiler le test de l'ihm en ligne de commande.
# Alternative (recommandee?): utiliser un IDE (eclipse, netbeans, ...)
# Le but est d'illustrer les notions de "classpath", a vous de l'adapter
# a votre projet.
#
# Organisation:
#  1) Les sources (*.java) se trouvent dans le repertoire src
#     Les classes d'un package toto sont dans src/toto
#     Les classes du package par defaut sont dans src
#
#  2) Les bytecodes (*.class) se trouvent dans le repertoire bin
#     La hierarchie des sources (par package) est conservee.
#     Pour un package (ici gui.jar), il est aussi dans bin.
#
# Compilation:
#  Options de javac:
#   -d : repertoire dans lequel sont places les .class compiles
#   -classpath : repertoire dans lequel sont cherches les .class deja compiles
#   -sourcepath : repertoire dans lequel sont cherches les .java (dependances)

all: testGUI

testGUI:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestGUI.java


# Execution:
# on peut taper directement la ligne de commande :
#   > java -classpath bin TestGUI
# ou bien lancer l'execution en passant par ce Makefile:
#   > make exeIHM
exeGUI:
	java -classpath bin:bin/gui.jar TestGUI

balls:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestBalls.java
	java -classpath bin:bin/gui.jar TestBalls

ballsGUI:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestBallsSimulator.java
	java -classpath bin:bin/gui.jar TestBallsSimulator

conway:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestConway.java
	java -classpath bin:bin/gui.jar TestConway

conwayGUI:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestConwaySimulator.java
	java -classpath bin:bin/gui.jar TestConwaySimulator

immigration:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestImmigration.java
	java -classpath bin:bin/gui.jar TestImmigration

immigrationGUI:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestImmigrationSimulator.java
	java -classpath bin:bin/gui.jar TestImmigrationSimulator

schelling:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestSchelling.java
	java -classpath bin:bin/gui.jar TestSchelling

schellingGUI:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestSchellingSimulator.java
	java -classpath bin:bin/gui.jar TestSchellingSimulator

boids:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestBoidsSimulator.java
	java -classpath bin:bin/gui.jar TestBoidsSimulator

eventMessage:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestEventMessage.java
	java -classpath bin:bin/gui.jar test/TestEventMessage

clean:
	rm -rf bin/*.class
