use crate::utils;

pub fn run_part2() {
    let mut safe_count = 0;
    for line in utils::read_lines("../Input/day2.1.txt") {
        let report: Vec<i64> = line.split(' ').map(|x| x.parse::<i64>().unwrap()).collect();
        if utils::is_safe(report.clone()) {
            safe_count += 1;
        } else {
            for i in 0..report.len() {
                let mut unsafe_reports = report.clone();
                unsafe_reports.remove(i);
                if utils::is_safe(unsafe_reports) {
                    safe_count += 1;
                    break;
                }
            }
        }
    }

    println!("{}", safe_count);
}