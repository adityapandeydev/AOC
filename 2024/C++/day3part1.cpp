#include <iostream>
#include <fstream>
#include <sstream>
#include <regex>
#include <vector>

using namespace std;

vector<string> split(const string &str, char delimiter) {
    vector<string> tokens;
    stringstream ss(str);
    string token;
    
    while (getline(ss, token, delimiter)) {
        tokens.push_back(token);
    }
    
    return tokens;
}

int main() {
    ifstream file("../Input/day3.txt");
    if (!file) {
        cerr << "Error opening file!" << endl;
        return 1;
    }

    int sum = 0;
    string line;
    while(getline(file, line)) {
        line = regex_replace(line, regex(R"((mul\(\d{1,3},\d{1,3}\))|.)"), "$1");
        line = regex_replace(line, regex(R"((\(\d{1,3},\d{1,3}\))|.)"), "$1");
        int i = 0;
        for (int j = 0; j < line.length(); j++) {
            if (line.at(j) == ')') {
                int firstNumber = stoi(split(line.substr(i + 1, j - (i + 1)), ',')[0]);
                int secondNumber = stoi(split(line.substr(i + 1, j - (i + 1)), ',')[1]);
                sum += firstNumber * secondNumber;
                i = j + 1;
            }
        }
    }
    cout << sum << endl;
    return 0;
}