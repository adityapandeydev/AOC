use crate::utils;

pub fn run_part1() {
    let mut safe_count = 0;
    for line in utils::read_lines("../Input/day2.1.txt") {
        let mut reports = Vec::new();
        let levels: Vec<&str> = line.split(' ').collect();
        for i in levels.iter() {
            reports.push(i.parse::<i64>().unwrap());
        }
        if utils::is_safe(reports) {
            safe_count += 1;
        }
    }

    println!("Reports: {}", safe_count);
}