# -*- coding: utf-8 -*-
# GCJ 2013 QR A. Tic-Tac-Toe-Tomek
X = 2
T = 1
O = 0
N = -1
win_stat = N

class StatusCheck

  def init()
    @no = T
    @x_array = []
    @o_array = []
  end


  def input_array(squares)
    for i in 0..3
      x_array_sub = []
      o_array_sub = []
      for j in 0..3
        case squares[i][j, 1]
        when 'X' then
          x_array_sub << X
          o_array_sub << X
        when 'T' then
          x_array_sub << T
          o_array_sub << T
        when 'O' then
          x_array_sub << O
          o_array_sub << O
        else
          x_array_sub << O
          o_array_sub << X
          @no = N
        end
      end
      @x_array << x_array_sub
      @o_array << o_array_sub
    end
  end

  def check_square()
    win_stat = check_col(@x_array, X, lambda{|arr,i,j| arr[i][j] > O})
    if win_stat != @no then
      return win_stat
    end

    win_stat = check_col(@o_array, O, lambda{|arr,i,j| arr[i][j] < X})
    if win_stat != @no then
      return win_stat
    end

    win_stat = check_row(@x_array, X, lambda{|arr,i,j| arr[i][j] > O})
    if win_stat != @no then
      return win_stat
    end

    win_stat = check_row(@o_array, O, lambda{|arr,i,j| arr[i][j] < X})
    if win_stat != @no then
      return win_stat
    end

    win_stat = check_dia(@x_array, X, lambda{|arr,i,j| arr[i][j] > O})
    if win_stat != @no then
      return win_stat
    end

    win_stat = check_dia(@o_array, O, lambda{|arr,i,j| arr[i][j] < X})
    if win_stat != @no then
      return win_stat
    end

    return @no
  end

  def check_col(array, x, testproc)
    for i in 0..3
      for j in 0..3
        if testproc.call(array,i,j) then
          if j == 3 then
            return x
          end
        else
          break;
        end
      end
    end
    return @no
  end

  def check_row(array, x, testproc)
    for j in 0..3
      for i in 0..3
        if testproc.call(array,i,j) then
          if i == 3 then
            return x
          end
        else
          break;
        end
      end
    end
    return @no
  end

  def check_dia(array, x, testproc)
    j = 0
    for i in 0..3
      if testproc.call(array,i,j) then
        if j == 3 then
          return x
        end
      else
        break;
      end
      j = j + 1;
    end
    j = 3
    for i in 0..3
      if testproc.call(array,i,j) then
        if j == 0 then
          return x
        end
      else
        break;
      end
      j = j - 1;
    end

    return @no
  end


end



test_case = gets.strip.to_i

for t_i in 1..test_case
  squares = []
  for i in 1..4
    squares << gets.strip
  end
  sc = StatusCheck.new
  sc.init()
  sc.input_array(squares)

  # check


  print "Case ##{t_i}: "

  case sc.check_square()
  when X then
    puts "X won"
  when O then
    puts "O won"
  when T then
    puts "Draw"
  when N then
    puts "Game has not completed"
  end
  gets
end

