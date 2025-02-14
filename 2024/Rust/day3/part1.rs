use crate::utils;
use regex::Regex;
use std::str::FromStr;

pub fn run_part1() {
    let mut sum = 0;
    let re1 = Regex::new(r"(mul\(\d{1,3},\d{1,3}\))|.").unwrap();
    let re2 = Regex::new(r"(\(\d{1,3},\d{1,3}\))|.").unwrap();
    for line in utils::read_lines("../Input/day3.txt") {
        let replaced = re1.replace_all(&line, |caps: &regex::Captures| {
            if let Some(matched) = caps.get(1) {
                matched.as_str().to_string()
            } else {
                "".to_string()
            }
        });
        let replaced_again = re2.replace_all(&replaced, |caps: &regex::Captures| {
            if let Some(matched) = caps.get(1) {
                matched.as_str().to_string()
            } else {
                "".to_string()
            }
        });
        let mut i = 0;
        let chars: Vec<char> = replaced_again.chars().collect();

        for j in 0..chars.len() {
            if chars[j] == ')' {
                if let Some(sub_string) = replaced_again.get(i + 1..j) {
                    let parts: Vec<&str> = sub_string.split(',').collect();
                    if parts.len() == 2 {
                        if let (Ok(first_number), Ok(second_number)) =
                            (i32::from_str(parts[0]), i32::from_str(parts[1])) {
                            sum += first_number * second_number;
                        }
                    }
                }
                i = j + 1;
            }
        }
    }
    println!("{}", sum);
}