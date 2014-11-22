class CreatePages < ActiveRecord::Migration
  def change
    create_table :pages do |t|
      t.string :index
      t.string :about
      t.string :help

      t.timestamps
    end
  end
end
