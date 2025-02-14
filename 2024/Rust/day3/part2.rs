use crate::utils;
use regex::Regex;
use std::str::FromStr;

pub fn run_part2() {
    let re = Regex::new(r"(do\(\))|(don't\(\))|(mul\((\d+),(\d+)\))").unwrap();
    let mut sum = 0;
    let mut flag = true;

    for line in utils::read_lines("../Input/day3.txt") {
        for cap in re.captures_iter(&line) {
            if cap.get(1).is_some() {
                flag = true;
            }
            if cap.get(2).is_some() {
                flag = false;
            }
            if let (Some(first), Some(second)) = (cap.get(4), cap.get(5)) {
                if flag {
                    if let (Ok(first_number), Ok(second_number)) =
                        (i32::from_str(first.as_str()), i32::from_str(second.as_str()))
                    {
                        sum += first_number * second_number;
                    }
                }
            }
        }
    }

    println!("{}", sum);
}
