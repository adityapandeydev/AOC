#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <cmath>

using namespace std;

bool isSafe(const vector<int>& report) {
    if (report.size() < 2) return true;
    int left = report[0];
    int right = report[1];
    bool isIncreasing = right > left;

    for (size_t i = 0; i < report.size() - 1; i++) {
        left = report[i];
        right = report[i + 1];
        bool difference = abs(right - left) >= 1 && abs(right - left) <= 3;

        if ((isIncreasing && left > right) || (!isIncreasing && right > left) || !difference) {
            return false;
        }
    }
    return true;
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
        }
    }
    cout << count << endl;
    return 0;
}