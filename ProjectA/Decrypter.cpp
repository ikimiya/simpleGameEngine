//Decrypter.cpp

#include <cstdio>
#include <iostream>
#include "Decrypter.h"

/**
 * @brief Construct a new Decrypter::Decrypter object
 */
Decrypter::Decrypter(){ 
}


/**
 * @brief Destroy the Decrypter::Decrypter object
 */
Decrypter::~Decrypter(void){ }


void Decrypter::setFile(std::string fileName){
 	 std::cout << "Test" << std::endl;
    cT.setFile(fileName);
    cD.setFile(fileName);

    kT.setFile(fileName);
    kD.setFile(fileName);

    aT.setFile(fileName);

}


/**
 * @brief Runs the encrypted file through all of the testing programs
 *        If on of the tests comes back as positive (1) set array to match 
 * 
 */
void Decrypter::test(void){

    cypherUsed[0] = cT.run();

    cypherUsed[1] = kT.run();

    cypherUsed[2] = 1;
    std::cout << "Anagram - Positive" << std::endl;

}

/**
 * @brief Run the decryption programs for the tests that came back as positive
 * 
 * @return int 
 *         1 - found correct plaintext solution
 *         0 - decryption didn't give correct plaintext
 */
int Decrypter::decypher(void){
    int valid = 0;

    if(cypherUsed[1] == 1){
        valid = kD.run();

        if(valid == 1){
            return 1;
        }

    }

    if(cypherUsed[0] == 1){
        valid = cD.fileR();

        if(valid == 1){
            return 1;
        }

    }

    if(cypherUsed[2] == 1){
        valid = aT.run();

        if(valid == 1){
            return 1;
        }

    }

    return 0;

}


/**
 * @brief Runs the decryption process
 * 
 * @return int
 *         1 - decryption succeeded
 *         0 - decryption failed
 */
int Decrypter::run(void){

    int r = 0;

    std::cout << std::endl << "----------------Starting The Decryption Process----------------" << std::endl;

    std::cout << std::endl << "Test Phase Starting" << std::endl << std::endl;
    test();
    std::cout << std::endl << "Test Phase Ending" << std::endl << std::endl;

    std::cout << std::endl << std::endl << "Decryption Phase Starting" << std::endl << std::endl;
    r = decypher();
    std::cout << std::endl << "Decryption Phase Ending" << std::endl;

    std::cout << std::endl << "----------------Ending The Decryption Process----------------" << std::endl << std::endl << std::endl;

    return r;
}
