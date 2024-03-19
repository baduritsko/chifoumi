#!/bin/bash

clear
echo "Compile & run Chifoumi Java Console"
cd ..
pwd
repertoires[0]='chifoumi/others/*.java'
repertoires[1]='chifoumi/models/*.java'
repertoires[2]='chifoumi/views/*.java'
repertoires[3]='chifoumi/controlers/*.java'
repertoires[4]='chifoumi/*.java'
compilationOK=true
for i in {0..4}
do
	compilation=$(javac ${repertoires[$i]})
	if [[ -z "$compilation" ]]
	then
		echo "[OK] : compilation de ${repertoires[$i]}"
	else
		echo "[KO] : compilation de ${repertoires[$i]}"
		compilationOK=false
	fi
done

if [ compilationOK ]
then
	echo "Démarrage de Chifoumi..."
	java chifoumi/Chifoumi $1
	echo "Chifoumi s'est arrêté"
else
	echo "Chifoumi ne peut pas démarrer, la compilation a retourné des erreurs"
fi