use std::fs::read_to_string;

pub fn read_lines(filename: &str) -> Vec<String> {
    let mut result = Vec::new();

    for line in read_to_string(filename).unwrap().lines() {
        result.push(line.to_string());
    }

    result
}

pub fn is_safe(report: Vec<i64>) -> bool {
    let first_pair = report.windows(2).next().unwrap();
    let is_increasing = first_pair[0] < first_pair[1];

    for pair in report.windows(2) {
        let difference = (pair[0] - pair[1]).abs();
        if difference > 3 || difference < 1 {
            return false;
        }
        if is_increasing && pair[0] >= pair[1] || !is_increasing && pair[0] <= pair[1] {
            return false;
        }
    }
    return true;
}