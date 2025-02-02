use crate::utils;

pub fn run_part1() {
    let mut array1: Vec<i32> = Vec::new();
    let mut array2: Vec<i32> = Vec::new();


    for line in utils::read_lines("../Input/day1.1.txt") {
        let parts: Vec<&str> = line.split(' ').collect();
        if parts.len() > 3 {
            array1.push(parts[0].parse::<i32>().unwrap());
            array2.push(parts[3].parse::<i32>().unwrap());
        }
    }
    array1.sort();
    array2.sort();

    let mut sum = 0;
    for (a, b) in array1.iter().zip(array2.iter()) {
        sum += (a - b).abs();
    }
    println!("{}", sum);
}