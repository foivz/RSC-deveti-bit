# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20141122130500) do

  # These are extensions that must be enabled in order to support this database
  enable_extension "plpgsql"

  create_table "addresses", force: true do |t|
    t.decimal  "long"
    t.decimal  "lat"
    t.text     "address"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "blood_groups", force: true do |t|
    t.datetime "created_at"
    t.datetime "updated_at"
    t.text     "group"
  end

  create_table "donors", force: true do |t|
    t.string   "email",                  default: "", null: false
    t.string   "encrypted_password",     default: "", null: false
    t.string   "reset_password_token"
    t.datetime "reset_password_sent_at"
    t.datetime "remember_created_at"
    t.integer  "sign_in_count",          default: 0,  null: false
    t.datetime "current_sign_in_at"
    t.datetime "last_sign_in_at"
    t.inet     "current_sign_in_ip"
    t.inet     "last_sign_in_ip"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.text     "first_name"
    t.text     "last_name"
    t.text     "push_reg_id"
    t.boolean  "locked"
    t.text     "note"
    t.datetime "date_of_last_donation"
  end

  add_index "donors", ["email"], name: "index_donors_on_email", unique: true, using: :btree
  add_index "donors", ["reset_password_token"], name: "index_donors_on_reset_password_token", unique: true, using: :btree

  create_table "institutions", force: true do |t|
    t.string   "email",                  default: "", null: false
    t.string   "encrypted_password",     default: "", null: false
    t.string   "reset_password_token"
    t.datetime "reset_password_sent_at"
    t.datetime "remember_created_at"
    t.integer  "sign_in_count",          default: 0,  null: false
    t.datetime "current_sign_in_at"
    t.datetime "last_sign_in_at"
    t.inet     "current_sign_in_ip"
    t.inet     "last_sign_in_ip"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.text     "name"
    t.text     "mail"
    t.integer  "low_level"
    t.boolean  "locked"
  end

  add_index "institutions", ["email"], name: "index_institutions_on_email", unique: true, using: :btree
  add_index "institutions", ["reset_password_token"], name: "index_institutions_on_reset_password_token", unique: true, using: :btree

  create_table "pages", force: true do |t|
    t.string   "index"
    t.string   "about"
    t.string   "help"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "super_admins", force: true do |t|
    t.string   "email",                  default: "", null: false
    t.string   "encrypted_password",     default: "", null: false
    t.string   "reset_password_token"
    t.datetime "reset_password_sent_at"
    t.datetime "remember_created_at"
    t.integer  "sign_in_count",          default: 0,  null: false
    t.datetime "current_sign_in_at"
    t.datetime "last_sign_in_at"
    t.inet     "current_sign_in_ip"
    t.inet     "last_sign_in_ip"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  add_index "super_admins", ["email"], name: "index_super_admins_on_email", unique: true, using: :btree
  add_index "super_admins", ["reset_password_token"], name: "index_super_admins_on_reset_password_token", unique: true, using: :btree

end
