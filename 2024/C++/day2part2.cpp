#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include "utils.h"

using namespace std;

vector<int> removeElement(const vector<int>& report, size_t index) {
    vector<int> newReport;
    for (size_t i = 0; i < report.size(); i++) {
        if (i != index) {
            newReport.push_back(report[i]);
        }
    }
    return newReport;
}

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
        } else {
            for (size_t i = 0; i < report.size(); i++) {
                vector<int> modifiedReport = removeElement(report, i);
                if (isSafe(modifiedReport)) {
                    count++;
                    break;
                }
            }
        }
    }
    cout << count << endl;
    return 0;
}