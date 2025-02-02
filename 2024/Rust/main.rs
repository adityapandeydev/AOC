mod day1;
mod day2;
mod utils;

use std::env;

fn main() {
    let args: Vec<String> = env::args().collect();

    if args.len() < 2 {
        println!("Please specify a day and part (e.g., cargo run -- day1part1)");
        return;
    }

    let day_part = args[1].as_str();

    match day_part {
        "day1part1" => {
            day1::part1::run_part1();
        }
        "day1part2" => {
            day1::part2::run_part2();
        }
        "day2part1" => {
            day2::part1::run_part1();
        }
        "day2part2" => {
            day2::part2::run_part2();
        }
        _ => {
            println!("Invalid day/part specified");
        }
    }
}
