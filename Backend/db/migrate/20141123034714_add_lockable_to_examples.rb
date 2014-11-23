class AddLockableToExamples < ActiveRecord::Migration
  def change
  	add_column :institutions, :failed_attempts, :integer, default: 0
    add_column :institutions, :unlock_token, :string
    add_column :institutions, :locked_at, :datetime

  end
end
