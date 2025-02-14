#include <iostream>
#include <fstream>
#include <regex>
#include <string>

using namespace std;

int main() {
    ifstream file("../Input/day3.txt");
    if (!file) {
        cerr << "Error opening file!" << endl;
        return 1;
    }

    string line;
    int sum = 0;
    bool flag = true;
    regex pattern(R"((do\(\))|(don't\(\))|(mul\((\d+),(\d+)\)))");

    while(getline(file, line)) {
        sregex_iterator it(line.begin(), line.end(), pattern);
        sregex_iterator end;

        while(it != end) {
            smatch match = *it;

            if (!match[1].str().empty()) {
                flag = true;
            }
            if (!match[2].str().empty()) {
                flag = false;
            }
            if (!match[3].str().empty() && flag) { 
                int firstNumber = std::stoi(match[4].str());
                int secondNumber = std::stoi(match[5].str());
                sum += (firstNumber * secondNumber);
            }
            ++it;
        }
    }
    cout << sum << endl;
    return 0;
}