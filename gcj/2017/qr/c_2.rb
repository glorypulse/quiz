# 2017/4/8 Google Code Jam
# Qualification Round C. Bathroom Stalls
# E.Yoshihara

require 'pqueue'

def main
  test_num = gets.chomp.to_i
  test_num.times do |t|
    # input
    n, k = gets.chomp.split(' ').map(&:to_i)

    ans = calc(k, n)
  
    # puts "Case ##{t+1}: #{ans}"
  end
end

@memo = Array.new(1000, '')
1000.times do |i|
  @memo[i] = Array.new(1000, '')
  @memo[i][0] = i + 1
end

def calc(k, n)
  pq = PQueue.new([n]){ |a,b| a > b }
  min = 0; max = n
  (k - 1).times do |ki|
    base = pq.pop
    @memo[n - 1][ki] = base
    # puts "#{n}, #{ki}: #{base}"
    if base.odd?
      2.times { pq.push((base - 1) / 2) }
    else
      pq.push(base / 2)
      pq.push(base / 2 - 1)
    end
  end
  
  base = pq.pop
  @memo[n - 1][k - 1] = base
  if base.odd?
    min = (base - 1) / 2
    max = (base - 1) / 2
  else
    min = base / 2 - 1
    max = base / 2
  end
  
  "#{max} #{min}"
end


main

print "NK, "
1000.times { |i|
  print "#{i + 1},"
}
puts
@memo.each.with_index do |marray, i|
  print "#{i + 1},"
  marray.each { |mi|
    print "#{mi},"
  }
  puts
end
