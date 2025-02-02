use crate::utils;

pub fn run_part1() {
    let mut safe_count = 0;
    for line in utils::read_lines("../Input/day2.1.txt") {
        let report: Vec<i64> = line.split(' ').map(|x| x.parse::<i64>().unwrap()).collect();
        if utils::is_safe(report) {
            safe_count += 1;
        }
    }

    println!("{}", safe_count);
}