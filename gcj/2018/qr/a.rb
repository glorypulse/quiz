# coding: utf-8
# frozen_string_literal: true
#
# 2018/4/7 Google Code Jam
# Qualification Round A Saving The Universe Again
# E. Yoshihara

require "thor"
require "pry"
require 'byebug'

def main
  t = gets.chomp.to_i
  t.times do |num|
    # input
    d, str_p = gets.chomp.split(' ')
    d = d.to_i

    ans = calc(d, str_p)
  
    puts "Case ##{num+1}: #{ans}"
  end
end

def c_index(str_p)
  c_indexes = []
  str_p.each_char.with_index do |c_p, i|
    next unless c_p == 'C'
    c_indexes << i
  end
  c_indexes
end

def beem_damage(c_array, length)
  return length if c_array.empty?
  damage = 0
  strength = 1
  (c_array + [length]).inject(0) do |c_pi, c_i|
    damage = strength * (c_i - c_pi)
    strength *= 2
    c_i + 1
  end
end

def ideal_p(d, s_num, c_array, length)
  max_ex = c_array.size
  ok_num = (1..max_ex).inject([1]) { |r, i| r << r.last * 2 }
  patterns = []
  puts "ok_num #{ok_num}"
  while(ok_num.last * s_num >= d) do
    patterns << pattern_d(ok_num, d, s_num, length, max_ex)
    ok_num.pop
    break if ok_num.empty?
  end
  patterns.compact
end

def pattern_d(ok_num, d, s_num, length, c_num)
  if ok_num.size == 1
    return ((length - c_num)..(length - 1)).to_a
  end
  
  coins = []
  r_d = d
  r_s = s_num
  @tracks = [[r_d, r_s, coins, ok_num]]
  if r_s > 0
    ok_num.each do
      @tracks.pop # nn...backtrackになってしまった
    end
  end

  pattern = []
  puts "coins #{coins}"
  coins.reverse[0..-2].inject(0) do |ri, coin|
    c_i = ri + coin
    pattern << c_i
    c_i
  end
  pattern
end

def seek_pattern(r_d, r_s, coins, ok_num)
  ok_num.each_with_index.reverse_each do |num, i|
    count = [r_d / num, r_s].min
    r_d -= count * num
    r_s -= count
    coins << count
    @tracks << [r_d, r_s, coins, ok_num]
    puts "num, count #{num}, #{count}"
    count = 0
  end
end

def calc(d, str_p)
  length = str_p.rindex('S')
  return 0 if length.nil?
  length += 1
  c_indexes = c_index(str_p[0..length-1])
  puts "c_indexes #{c_indexes.to_s}"
  c_num = c_indexes.size
  s_num = length - c_num
  return 'IMPOSSIBLE' if s_num > d

  patterns = ideal_p(d, s_num, c_indexes, length)
  puts "patterns #{patterns.to_s}"
  answers = patterns.map do |pattern|
    pattern.zip(c_indexes).inject(0) do |r, (p, c_i)|
      if c_i < p
        r + (p - c_i)
      else
        r
      end
    end
  end
  return answers.min
end

main
