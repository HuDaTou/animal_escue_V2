<template>
	<div class="diy_edit page_adoption_application" id="adoption_application_edit">
		<div class='warp'>
			<div class='container'>
				<div class='row diy_edit_content_box'>
						<div v-if="$check_field('set','animal_no') || $check_field('add','animal_no') || $check_field('get','animal_no')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								动物编号:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_animal_no" v-model="form['animal_no']" placeholder="请输入动物编号" v-if="(form['animal_no'] && $check_field('set','animal_no')) || (!form['animal_no'] && $check_field('add','animal_no'))"  :disabled="disabledObj['animal_no_isDisabled']"/>
							<span v-else-if="$check_field('get','animal_no')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','animal_name') || $check_field('add','animal_name') || $check_field('get','animal_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								动物名称:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_animal_name" v-model="form['animal_name']" placeholder="请输入动物名称" v-if="(form['animal_name'] && $check_field('set','animal_name')) || (!form['animal_name'] && $check_field('add','animal_name'))"  :disabled="disabledObj['animal_name_isDisabled']"/>
							<span v-else-if="$check_field('get','animal_name')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','animal_sex') || $check_field('add','animal_sex') || $check_field('get','animal_sex')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								动物性别:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_animal_sex" v-model="form['animal_sex']" placeholder="请输入动物性别" v-if="(form['animal_sex'] && $check_field('set','animal_sex')) || (!form['animal_sex'] && $check_field('add','animal_sex'))"  :disabled="disabledObj['animal_sex_isDisabled']"/>
							<span v-else-if="$check_field('get','animal_sex')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','user_no') || $check_field('add','user_no') || $check_field('get','user_no')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								用户编号:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_user_no" :disabled="disabledObj['user_no_isDisabled']" v-model="form['user_no']" v-if="(form['user_no'] && $check_field('set','user_no')) || (!form['user_no'] && $check_field('add','user_no'))" >
								<option v-for="o in list_user_user_no" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','user_no')">{{ form['user_no'] }}</span>
						</div>
					</div>
							<div v-if="$check_field('set','name_of_adopter') || $check_field('add','name_of_adopter') || $check_field('get','name_of_adopter')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								领养人姓名:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_name_of_adopter" v-model="form['name_of_adopter']" placeholder="请输入领养人姓名" v-if="(form['name_of_adopter'] && $check_field('set','name_of_adopter')) || (!form['name_of_adopter'] && $check_field('add','name_of_adopter'))"  :disabled="disabledObj['name_of_adopter_isDisabled']"/>
							<span v-else-if="$check_field('get','name_of_adopter')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','contact_information') || $check_field('add','contact_information') || $check_field('get','contact_information')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								联系方式:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_contact_information" v-model="form['contact_information']" placeholder="请输入联系方式" v-if="(form['contact_information'] && $check_field('set','contact_information')) || (!form['contact_information'] && $check_field('add','contact_information'))"  :disabled="disabledObj['contact_information_isDisabled']"/>
							<span v-else-if="$check_field('get','contact_information')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','do_you_care_for_animals') || $check_field('add','do_you_care_for_animals') || $check_field('get','do_you_care_for_animals')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								是否爱护动物:
							</span>
						</div>
								<!-- 选项 -->
						<div class="diy_field diy_down">
							<select id="form_do_you_care_for_animals" v-model="form['do_you_care_for_animals']" v-if="(form['do_you_care_for_animals'] && $check_field('set','do_you_care_for_animals')) || (!form['do_you_care_for_animals'] && $check_field('add','do_you_care_for_animals'))" >
								<option v-for="o in list_do_you_care_for_animals" :value="o">
									{{o}}
								</option>
							</select>
							<span v-else-if="$check_field('get','do_you_care_for_animals')">{{ form['do_you_care_for_animals'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','family_adoption_environment') || $check_field('add','family_adoption_environment') || $check_field('get','family_adoption_environment')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								家庭收养动物环境:
							</span>
						</div>
								<!-- 多文本 -->
						<div class="diy_field diy_desc">
							<textarea id="form_family_adoption_environment" v-model="form['family_adoption_environment']" v-if="(form['family_adoption_environment'] && $check_field('set','family_adoption_environment')) || (!form['family_adoption_environment'] && $check_field('add','family_adoption_environment'))" :disabled="disabledObj['family_adoption_environment_isDisabled']" />
							<span v-else-if="$check_field('get','family_adoption_environment')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
	


					<div v-if="user_group === '管理员' || $check_examine()" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								审核状态:
							</span>
						</div>
						<div class="diy_field diy_select" v-if="$check_action('/adoption_application/edit','examine')">
							<!--<span> {{ form['examine_state'] }} </span>-->
							<select v-model="form['examine_state']">
								<option value="未审核">
									未审核
								</option>
								<option value="已通过">
									已通过
								</option>
								<option value="未通过">
									未通过
								</option>
							</select>
						</div>
						<div class="diy_field diy_text" v-else>
							<span>
								{{ form['examine_state'] }}
							</span>
						</div>
					</div>
					<div v-if="user_group === '管理员' || $check_examine()" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								审核回复:
							</span>
						</div>
						<div class="diy_field diy_desc" v-if="$check_action('/adoption_application/edit','examine')">
							<textarea v-model="form['examine_reply']"></textarea>
						</div>
						<div class="diy_field diy_text" v-else>
							<span>
								{{ form['examine_reply'] }}
							</span>
						</div>
					</div>


				</div>
				<div class="diy_edit_submit_box row">
					<div class="col-12">
						<div class="btn_box">
							<button class="btn_submit" @click="submit()">提交</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import mixin from "@/mixins/page.js";
	export default {
		mixins: [mixin],
		components: {},
		data() {
			return {
				url_get_obj: "~/api/adoption_application/get_obj?",
				url_add: "~/api/adoption_application/add?",
				url_set: "~/api/adoption_application/set?",

				// 登录权限
				oauth: {
					"signIn": true,
					"user_group": []
				},

				// 查询条件
				query: {
						"animal_no": "",
							"animal_name": "",
							"animal_sex": "",
							"user_no": 0,
							"name_of_adopter": "",
							"contact_information": "",
							"do_you_care_for_animals": "",
							"family_adoption_environment": "",
						"adoption_application_id": 0,
				},

				obj: {
						"animal_no":  '', // 动物编号
							"animal_name":  '', // 动物名称
							"animal_sex":  '', // 动物性别
							"user_no": 0, // 用户编号
							"name_of_adopter":  '', // 领养人姓名
							"contact_information":  '', // 联系方式
							"do_you_care_for_animals":  '', // 是否爱护动物
							"family_adoption_environment":  '', // 家庭收养动物环境
						"examine_state": "未审核",
					"examine_reply": "",
					"adoption_application_id": 0,
				},

				// 表单字段
				form: {
						"animal_no":  '', // 动物编号
							"animal_name":  '', // 动物名称
							"animal_sex":  '', // 动物性别
							"user_no": 0, // 用户编号
							"name_of_adopter":  '', // 领养人姓名
							"contact_information":  '', // 联系方式
							"do_you_care_for_animals":  '', // 是否爱护动物
							"family_adoption_environment":  '', // 家庭收养动物环境
						"examine_state": "未审核",
					"examine_reply": "",
					"adoption_application_id": 0,
				},
				disabledObj:{
						"animal_no_isDisabled": false,
							"animal_name_isDisabled": false,
							"animal_sex_isDisabled": false,
							"user_no_isDisabled": false,
							"name_of_adopter_isDisabled": false,
							"contact_information_isDisabled": false,
							"do_you_care_for_animals_isDisabled": false,
							"family_adoption_environment_isDisabled": false,
					},

												// 用户列表
				list_user_user_no: [],
										// 是否爱护动物选项列表
				list_do_you_care_for_animals: ['是','否'],
				
				// ID字段
				field: "adoption_application_id",

			}
		},
		methods: {
			
				
				
						/**
			 * 获取注册用户用户列表
			 */
			async get_list_user_user_no() {
				// if(this.user_group !== "管理员" && this.form["user_no"] === 0) {
				//     this.form["user_no"] = this.user.user_id;
				// }
				var json = await this.$get("~/api/user/get_list?user_group=注册用户");
				if(json.result && json.result.list){
					this.list_user_user_no = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
					async get_user_session_user_no(){
				var _this = this;
				var json = await this.$get("~/api/user_group/get_obj?name=注册用户");
				if(json.result && json.result.obj){
					var source_table = json.result.obj.source_table;
					var user_id = _this.$store.state.user.user_id;
					if (user_id){
						var url = "~/api/"+source_table+"/get_obj?"
						this.$get(url, {"user_id":_this.$store.state.user.user_id}, function(res) {
							if (res.result && res.result.obj) {
								var arr = []
								for (let key in res.result.obj) {
									arr.push(key)
								}
								var arrForm = []
								for (let key in _this.form) {
									arrForm.push(key)
								}
								_this.form["user_no"] = user_id
								_this.disabledObj['user_no' + '_isDisabled'] = true
								for (var i=0;i<arr.length;i++){
                  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
                    for (var j = 0; j < arrForm.length; j++) {
                      if (arr[i] === arrForm[j]) {
                        if (arr[i] !== "user_no") {
                          _this.form[arrForm[j]] = res.result.obj[arr[i]]
                          _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                          break;
                        }
                      }
                    }
                  }
								}
							}
						});
					}
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
				
				
				
				
	
			/**
			 * 修改文件
			 * @param { Object } files 上传文件对象
			 * @param { String } str 表单的属性名
			 */
			change_file(files, str) {
				var form = new FormData();
				form.append("file", files[0]);
				this.$post("~/api/adoption_application/upload?", form, (res) => {
					if (res.result) {
						this.form[str] = res.result.url;
					} else if (res.error) {
						this.$toast(res.error.message);
					}
				});
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_before(param){
				var form = $.db.get("form");
				// if (form) {
        //   delete(form.examine_state)
        //   delete(form.examine_reply)
        //   this.obj = $.push(this.obj ,form);
				// 	this.form = $.push(this.form ,form);
				// }
				// var arr = []
				// for (let key in form) {
				// 	arr.push(key)
				// }
				// for (var i=0;i<arr.length;i++){
				// 	this.disabledObj[arr[i] + '_isDisabled'] = true
				// }
        if (form) {
          var arr = []
          for (let key in form) {
            arr.push(key)
          }
          var arrForm = []
          for (let key in this.form) {
            arrForm.push(key)
          }
          for (var i=0;i<arr.length;i++){
            if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
              for (var j = 0; j < arrForm.length; j++) {
                if (arrForm[j] === arr[i]) {
                  this.form[arrForm[j]] = form[arr[i]]
                  this.obj[arrForm[j]] = form[arr[i]]
                  this.disabledObj[arrForm[j] + '_isDisabled'] = true
                  break;
                }
              }
            }
          }
        }
																
        $.db.del("form");
				return param;
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json ,func){
				// var form = $.db.get("form");
				// var obj = Object.assign({} ,form ,this.obj);
				// if (obj) {
        //   delete(obj.examine_state)
        //   delete(obj.examine_reply)
				// 	this.obj = $.push(this.obj ,obj);
				// }
				// if (form) {
        //   delete(form.examine_state)
        //   delete(form.examine_reply)
				// 	this.form = $.push(this.form ,form);
				// }
				if(func){
					func(json);
				}
			},


		},
		created() {
														this.get_user_session_user_no();
					this.get_list_user_user_no();
															},
	}
</script>

<style>




</style>
