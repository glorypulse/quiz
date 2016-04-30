# -*- coding: utf-8 -*-
# GCJ 2014 QR A. Magic Trick

require "bigdecimal"

test_case = gets.chomp.to_i

for t_i in 1..test_case
  line = gets.chomp.split(" ")
  c = BigDecimal(line[0], 15)
  f = BigDecimal(line[1], 15)
  x = BigDecimal(line[2], 15)

  n = ((x * f - BigDecimal("2", 15) * c - c * f) / (c * f)).to_i
  if  n < 0  then
    n = 0
  end
  puts "n: #{n}"
  sum = BigDecimal("0", 15)
  for m in 1..n
    sum = sum + (BigDecimal("1", 15) / (BigDecimal("2", 15) + BigDecimal(m.to_s, 15) * f - f))
    puts "sum #{m}: #{sum}"
  end

  second = x / (BigDecimal("2", 15) + n * f) + c * sum

  print "Case ##{t_i}: "
  puts sprintf( "%.6f", second )
  
end


