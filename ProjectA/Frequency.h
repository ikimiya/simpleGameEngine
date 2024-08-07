// -*- C++ -*-
// Frequency.h

#ifndef _FREQUENCY_H_
#define _FREQUENCY_H_

#include <iostream> 
#include <sstream>
#include "FileRead.h"
#include "AnalyzeCipher.h"
#include <array>

class Frequency {

public:

    Frequency(void);

    // initilizer consturcotr
    Frequency(std::string inputFile);

    ~Frequency(void);

    void findFrequency(void);

    void printFrequency(void);

    void printArray(void);

    bool compareLetter(char letter);

    void createArray(void);

    void convertPercentage(void);

    void frequencySorter(void);

    void readFile(std::string inputFile);

    void readAndCalculate(void);

    void Start(void);

    void debug(void);

    // converts highFrequencyAlpha into returnable array
    std::array<float,26> getFrequencyArray();
    std::array<char,26> getFrequencyAlphabet();

    // fileRead class instance to read file 
    FileRead fRead;

    // analyzeCipher for Coindex index
    AnalyzeCipher aCipher;

    // high to low frequency
    std::array<float,26> highFrequencyAlpha;
    std::array<float,26> highAlpha;
    std::array<float,26> freqAlpha;
    std::array<float,26> percentAlpha;

    // used for sorted low to high frequency
    //char highAlpha[26];

    // float array for frequency counter 
    //float freqAlpha[26]; 
    //float percentAlpha[26];




    // used for testing
    std::array<float,26> testArray;
    std::array<char,26> testAlpha;

    // used for copy array
    std::array<float,26> frequencyArray;

     // alphabet string
    std::string alphabet = "abcdefghijklmnopqrstuvwxyz";

    // used to convert char to string
    std::stringstream stream;

    // variable to store currentFile name 
    std::string currentFile; 

    std::string cipherText;


};



#endif


