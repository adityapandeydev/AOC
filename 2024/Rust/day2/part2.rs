use crate::utils;

pub fn run_part2() {
    let mut safe_count = 0;
    for line in utils::read_lines("../Input/day2.1.txt") {
        let mut reports = Vec::new();
        let levels: Vec<&str> = line.split(' ').collect();
        for i in levels.iter() {
            reports.push(i.parse::<i64>().unwrap());
        }
        if utils::is_safe(reports.clone()) {
            safe_count += 1;
        } else {
            for i in 0..reports.len() {
                let mut unsafe_reports = reports.clone();
                unsafe_reports.remove(i);
                if utils::is_safe(unsafe_reports) {
                    safe_count += 1;
                    break;
                }
            }
        }
    }

    println!("Reports: {}", safe_count);
}