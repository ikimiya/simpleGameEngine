// -*- C++ -*-
// Frequency.cpp

#include "Frequency.h"
#include <iostream>
#include <iomanip> // for output manipulator std::setprecision()

// empty constructor 
Frequency::Frequency(void)
{   
    // initalize empty arrays
    createArray();
}

// initalizer
Frequency::Frequency(std::string inputFile)
{   
    // initalize array
    createArray();

    readFile(inputFile);

    // calcualte values with current file
    readAndCalculate();

}

Frequency::~Frequency(void)
{

}

// finds the frequency
void Frequency::findFrequency(void)
{

    std::string tempCipher = fRead.cipherText;
    int length = tempCipher.length();

    std::string test = "hello";
    int testLength = test.length();

    for (int i = 0; i < length; i++)
    {

        char cipherLetter = tempCipher[i];

        // if empty ignore
        if(cipherLetter == ' ')
        {
            //std::cout << "true" << std::endl;
        }else{
            compareLetter(cipherLetter);
        }
    }

}

// checks for alphabetic 
bool Frequency::compareLetter(char letter)
{
    std::string tempLetter;

    // convert to lower
    char tempChar = (tolower(letter));

    // convert char to stirng "a"
    stream << tempChar;
    stream >> tempLetter;

    int index = alphabet.find(tempLetter);

    stream.str("");
    stream.clear();

    // -1 = false
    if(index == -1){
        return false;
    }else{
        //std::cout << "fq " << freqAlpha[index] << std::endl;
        int count = freqAlpha[index];
        freqAlpha[index]++;
        return true;
    }

}

// prints frequency percentage
void Frequency::printFrequency(void)
{
    //precision percentage 
    for(int i = 0; i < 26; i++){
        std::cout << "alphabet:" << alphabet[i] << "). " << percentAlpha[i] << std::endl;
    }
}

// prints floats array 
void Frequency::printArray(void)
{
    for(int i = 0; i < 26; i++){
        std::cout << "alphabet:" << alphabet[i] << "). " << freqAlpha[i] << std::endl;
    } // end array
}

// create initial null values
void Frequency::createArray(void){

    // initalize empty arrays
    for(int i = 0; i < 26; i++){
        freqAlpha[i] = 0;
    }

    for(int i = 0; i < 26; i++){
        percentAlpha[i] = 0;
    }

    // inialize alphabet values for array
    for(int i = 0; i < 26; i++){
        highAlpha[i] = alphabet[i];
    }

}

void Frequency::convertPercentage(void){

    //FileReadcipherText;
    for(int i = 0; i < 26; i++){
        percentAlpha[i] = freqAlpha[i] / fRead.cipherLength() * 100;
        //std::cout << "test:) " << alphabet[i] << " " <<  freqAlpha[i] / fRead.cipherLength() * 100 << std::endl;
    }
}

// Takes Unsorted Frequency Alpha and sort and copy to high frequency ALpha
void Frequency::frequencySorter(void)
{
    // first copy regular frequency to new array using std:: algorithm
    std::copy(std::begin(freqAlpha), std::end(freqAlpha), std::begin(highFrequencyAlpha));

    // Sort highAlpha and highFrequencyAlpha
    for(int i = 0; i < 26; i++){
        float lowestNumber = highFrequencyAlpha[i];
        char lowAlphabet = highAlpha[i];

        int currentIndex;
        for(int j = 0; j < 26;j++){
            float currentNumber = highFrequencyAlpha[j];
            char currentAlpha = highAlpha[j];

            // swap values
            if(lowestNumber > highFrequencyAlpha[j]){
                highFrequencyAlpha[i] = highFrequencyAlpha[j];
                highFrequencyAlpha[j] = lowestNumber;
                lowestNumber = highFrequencyAlpha[i];

                highAlpha[i] = highAlpha[j];
                highAlpha[j] = lowAlphabet;
                lowAlphabet = highAlpha[i];
            } // end if
        } // end for
    } // end for
} // end if


// returns float frequency array for high to low order
std::array<float,26> Frequency::getFrequencyArray(){
    std::array<float,26> highLowArray;

    for(int i = 0; i < 26; i++){
        highLowArray[i] = highFrequencyAlpha[i];
    } // end for
    
    return highLowArray;
}

// returns char alphabet array for high to low order array 
std::array<char,26> Frequency::getFrequencyAlphabet()
{
    std::array<char,26> highLowAlphabet;

    for(int i = 0; i < 26; i++){
        highLowAlphabet[i] = highAlpha[i];

    }
    return highLowAlphabet;
}

void Frequency::readFile(std::string inputFile)
{
    currentFile = inputFile;
    fRead.readFile(currentFile);
}

void Frequency::readAndCalculate(void)
{
    // resets array
    createArray();

    // calculate frequency of letters
    findFrequency();
    
    // convert frequency of letters to percentage in new array
    convertPercentage();

    // sorts high low frequency
    frequencySorter();

    // calculates coIndex
    frequencyArray = getFrequencyArray();
    aCipher.coIndex(frequencyArray, (fRead.cipherLength()));

    cipherText = fRead.cipherText;
}

void Frequency::Start(void)
{
    std::cout << "Printing Test" << std::endl;

    /*
        test to read file
        function to read/change current file 
    */ 
    readFile("cipher1.txt");

    // function to calcuate data for array
    readAndCalculate();
    
    std::cout << "Printing unsorted Array" << std::endl;
    printArray();

    std::cout << "printing sorted array" << std::endl;
    debug();

    // print test
    std::cout << "Current File Name: " << currentFile << std::endl;
    std::cout << "PlainText: " << fRead.plainText << std::endl;
    std::cout << "CipherText: " << fRead.cipherText << std::endl;
    std::cout << "Length of Ciphertext: " << fRead.cipherLength() << std::endl;
    std::cout << "Calculated CI of CipherText: "<< aCipher.CI << std::endl;
    

}

void Frequency::debug(void)
{
    std::cout << "Printing array:" << std::endl;
    /*
    // test to print alphabet with highfrequency
    for(int i = 0; i < 26; i++){
        std::cout << highAlpha[i] << " " << highFrequencyAlpha[i] << std::endl;
    }
    */

    // gets array for high low frequency order
    testArray = getFrequencyArray();
    testAlpha = getFrequencyAlphabet();

    for(int i = 0; i < 26; i++){
        std::cout << "Alpha:"<< testAlpha[i] << "). Freq: " << testArray[i] << std::endl;
    }
    
}