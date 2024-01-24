<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','animal_no') || $check_field('add','animal_no') || $check_field('set','animal_no')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="动物编号" prop="animal_no">
												<el-input id="animal_no" v-model="form['animal_no']" placeholder="请输入动物编号"
							  v-if="user_group === '管理员' || (form['adoption_application_id'] && $check_field('set','animal_no')) || (!form['adoption_application_id'] && $check_field('add','animal_no'))" :disabled="disabledObj['animal_no_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','animal_no')">{{form['animal_no']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','animal_name') || $check_field('add','animal_name') || $check_field('set','animal_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="动物名称" prop="animal_name">
												<el-input id="animal_name" v-model="form['animal_name']" placeholder="请输入动物名称"
							  v-if="user_group === '管理员' || (form['adoption_application_id'] && $check_field('set','animal_name')) || (!form['adoption_application_id'] && $check_field('add','animal_name'))" :disabled="disabledObj['animal_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','animal_name')">{{form['animal_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','animal_sex') || $check_field('add','animal_sex') || $check_field('set','animal_sex')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="动物性别" prop="animal_sex">
												<el-input id="animal_sex" v-model="form['animal_sex']" placeholder="请输入动物性别"
							  v-if="user_group === '管理员' || (form['adoption_application_id'] && $check_field('set','animal_sex')) || (!form['adoption_application_id'] && $check_field('add','animal_sex'))" :disabled="disabledObj['animal_sex_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','animal_sex')">{{form['animal_sex']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_no') || $check_field('add','user_no') || $check_field('set','user_no')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户编号" prop="user_no">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_user_no(form['user_no']) }}
							<!--<el-input id="business_name" v-model="form['user_no']" placeholder="请输入用户编号"-->
							<!--v-if="user_group === '管理员' || (form['adoption_application_id'] && $check_field('set','user_no')) || (!form['adoption_application_id'] && $check_field('add','user_no'))" :disabled="disabledObj['user_no_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','user_no')">{{form['user_no']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['adoption_application_id'] && $check_field('set','user_no')) || (!form['adoption_application_id'] && $check_field('add','user_no'))" id="user_no" v-model="form['user_no']" :disabled="disabledObj['user_no_isDisabled']">
								<el-option v-for="o in list_user_user_no" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','user_no')" id="user_no" v-model="form['user_no']" :disabled="true">
								<el-option v-for="o in list_user_user_no" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="user_no" v-model="form['user_no']" :disabled="disabledObj['user_no_isDisabled']">
							<el-option v-for="o in list_user_user_no" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','name_of_adopter') || $check_field('add','name_of_adopter') || $check_field('set','name_of_adopter')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="领养人姓名" prop="name_of_adopter">
												<el-input id="name_of_adopter" v-model="form['name_of_adopter']" placeholder="请输入领养人姓名"
							  v-if="user_group === '管理员' || (form['adoption_application_id'] && $check_field('set','name_of_adopter')) || (!form['adoption_application_id'] && $check_field('add','name_of_adopter'))" :disabled="disabledObj['name_of_adopter_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','name_of_adopter')">{{form['name_of_adopter']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','contact_information') || $check_field('add','contact_information') || $check_field('set','contact_information')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="联系方式" prop="contact_information">
												<el-input id="contact_information" v-model="form['contact_information']" placeholder="请输入联系方式"
							  v-if="user_group === '管理员' || (form['adoption_application_id'] && $check_field('set','contact_information')) || (!form['adoption_application_id'] && $check_field('add','contact_information'))" :disabled="disabledObj['contact_information_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','contact_information')">{{form['contact_information']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','do_you_care_for_animals') || $check_field('add','do_you_care_for_animals') || $check_field('set','do_you_care_for_animals')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="是否爱护动物" prop="do_you_care_for_animals">
								<el-select id="do_you_care_for_animals" v-model="form['do_you_care_for_animals']"
						v-if="user_group === '管理员' || (form['adoption_application_id'] && $check_field('set','do_you_care_for_animals')) || (!form['adoption_application_id'] && $check_field('add','do_you_care_for_animals'))">
						<el-option v-for="o in list_do_you_care_for_animals" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','do_you_care_for_animals')">{{form['do_you_care_for_animals']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','family_adoption_environment') || $check_field('add','family_adoption_environment') || $check_field('set','family_adoption_environment')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="家庭收养动物环境" prop="family_adoption_environment">
								<el-input type="textarea" id="family_adoption_environment" v-model="form['family_adoption_environment']" placeholder="请输入家庭收养动物环境"
						v-if="user_group === '管理员' || (form['adoption_application_id'] && $check_field('set','family_adoption_environment')) || (!form['adoption_application_id'] && $check_field('add','family_adoption_environment'))" :disabled="disabledObj['family_adoption_environment_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','family_adoption_environment')">{{form['family_adoption_environment']}}</div>
							</el-form-item>
			</el-col>
							<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核状态" prop="examine_state">
					<el-select id="examine_state" v-model="form['examine_state']"
						v-if="user_group === '管理员' || (form['examine_state'] && $check_examine()) || (!form['examine_state'] && $check_examine())">
						<el-option key="未审核" label="未审核" value="未审核"></el-option>
						<el-option key="已通过" label="已通过" value="已通过"></el-option>
						<el-option key="未通过" label="未通过" value="未通过"></el-option>
					</el-select>
					<div v-else>{{form["examine_state"]}}</div>
				</el-form-item>
			</el-col>
					<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核回复" prop="examine_reply">
					<el-input id="examine_reply" v-model="form['examine_reply']" placeholder="请输入审核回复"
						v-if="user_group === '管理员' || (form['examine_reply'] && $check_examine()) || (!form['examine_reply'] && $check_examine())"></el-input>
					<div v-else>{{form["examine_reply"]}}</div>
				</el-form-item>
			</el-col>
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "adoption_application_id",
				url_add: "~/api/adoption_application/add?",
				url_set: "~/api/adoption_application/set?",
				url_get_obj: "~/api/adoption_application/get_obj?",
				url_upload: "~/api/adoption_application/upload?",

				query: {
					"adoption_application_id": 0,
				},

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
							"adoption_application_id": 0, // ID
					
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
						// 用户组
				group_user_user_no: "",
				
		
						// 是否爱护动物选项列表
				list_do_you_care_for_animals: ['是','否'],
	
		
	
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
					/**
			 * 获取注册用户用户组
			 */
			async get_group_user_user_no() {
							this.form["user_no"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=注册用户");
				if(json.result && json.result.obj){
					this.group_user_user_no = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_user_no(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_user_no.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
									for (let key in _this.form) {
							arrForm.push(key)
						}
												_this.form["user_no"] = id
									_this.disabledObj['user_no' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "user_no") {
			                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
			                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								  break;
								} else {
								  _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								}
							  }
							}
						  }
						}
					}
				});
			},
					get_user_user_no(id){
				var obj = this.list_user_user_no.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
										// 获取缓存数据附加
				form = $.db.get("form");
							$.push(this.form ,form);
									
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
																				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																								

			},


			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/adoption_application/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/adoption_application/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/adoption_application/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/adoption_application/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/adoption_application/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},


		},
		created() {
											this.get_list_user_user_no();
					this.get_group_user_user_no();
													},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
