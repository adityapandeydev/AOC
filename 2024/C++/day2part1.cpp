#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include "utils.h"

using namespace std;

int main() {
    ifstream file("../Input/day2.1.txt");
    if (!file) {
        cerr << "Error opening file!" << endl;
        return 1;
    }

    int count = 0;
    string line;

    while (getline(file, line)) {
        stringstream ss(line);
        vector<int> report;
        int num;

        while (ss >> num) {
            report.push_back(num);
        }

        if (isSafe(report)) {
            count++;
        }
    }
    cout << count << endl;
    return 0;
}