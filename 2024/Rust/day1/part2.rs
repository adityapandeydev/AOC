use crate::utils;
use std::collections::HashMap;

pub fn run_part2() {
    let mut array1: Vec<i32> = Vec::new();
    let mut map: HashMap<i32, i32> = HashMap::new();


    for line in utils::read_lines("../Input/day1.1.txt") {
        let parts: Vec<&str> = line.split(' ').collect();
        if parts.len() > 3 {
            array1.push(parts[0].parse::<i32>().unwrap());
            let key = parts[3].parse::<i32>().unwrap();
            if !map.contains_key(&key) {
                map.insert(key, 1);
            } else {
                let count = map.get(&key).unwrap();
                map.insert(key, count + 1);
            }
        }
    }

    let mut sum = 0;
    for a in array1.iter() {
        if map.contains_key(&a) {
            sum += a * map.get(&a).unwrap();
        }
    }
    println!("{}", sum);
}