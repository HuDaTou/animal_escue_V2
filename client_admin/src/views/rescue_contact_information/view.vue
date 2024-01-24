<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','name_of_rescue_station') || $check_field('add','name_of_rescue_station') || $check_field('set','name_of_rescue_station')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="救助站名称" prop="name_of_rescue_station">
												<el-input id="name_of_rescue_station" v-model="form['name_of_rescue_station']" placeholder="请输入救助站名称"
							  v-if="user_group === '管理员' || (form['rescue_contact_information_id'] && $check_field('set','name_of_rescue_station')) || (!form['rescue_contact_information_id'] && $check_field('add','name_of_rescue_station'))" :disabled="disabledObj['name_of_rescue_station_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','name_of_rescue_station')">{{form['name_of_rescue_station']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','position') || $check_field('add','position') || $check_field('set','position')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="位置" prop="position">
												<el-input id="position" v-model="form['position']" placeholder="请输入位置"
							  v-if="user_group === '管理员' || (form['rescue_contact_information_id'] && $check_field('set','position')) || (!form['rescue_contact_information_id'] && $check_field('add','position'))" :disabled="disabledObj['position_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','position')">{{form['position']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','animal_name') || $check_field('add','animal_name') || $check_field('set','animal_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="动物名称" prop="animal_name">
												<el-input id="animal_name" v-model="form['animal_name']" placeholder="请输入动物名称"
							  v-if="user_group === '管理员' || (form['rescue_contact_information_id'] && $check_field('set','animal_name')) || (!form['rescue_contact_information_id'] && $check_field('add','animal_name'))" :disabled="disabledObj['animal_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','animal_name')">{{form['animal_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','salvage_requirements') || $check_field('add','salvage_requirements') || $check_field('set','salvage_requirements')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="救助要求" prop="salvage_requirements">
								<el-input type="textarea" id="salvage_requirements" v-model="form['salvage_requirements']" placeholder="请输入救助要求"
						v-if="user_group === '管理员' || (form['rescue_contact_information_id'] && $check_field('set','salvage_requirements')) || (!form['rescue_contact_information_id'] && $check_field('add','salvage_requirements'))" :disabled="disabledObj['salvage_requirements_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','salvage_requirements')">{{form['salvage_requirements']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','matters_needing_attention') || $check_field('add','matters_needing_attention') || $check_field('set','matters_needing_attention')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="注意事项" prop="matters_needing_attention">
								<el-input type="textarea" id="matters_needing_attention" v-model="form['matters_needing_attention']" placeholder="请输入注意事项"
						v-if="user_group === '管理员' || (form['rescue_contact_information_id'] && $check_field('set','matters_needing_attention')) || (!form['rescue_contact_information_id'] && $check_field('add','matters_needing_attention'))" :disabled="disabledObj['matters_needing_attention_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','matters_needing_attention')">{{form['matters_needing_attention']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','contacts') || $check_field('add','contacts') || $check_field('set','contacts')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="联系人" prop="contacts">
												<el-input id="contacts" v-model="form['contacts']" placeholder="请输入联系人"
							  v-if="user_group === '管理员' || (form['rescue_contact_information_id'] && $check_field('set','contacts')) || (!form['rescue_contact_information_id'] && $check_field('add','contacts'))" :disabled="disabledObj['contacts_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','contacts')">{{form['contacts']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','contact_information') || $check_field('add','contact_information') || $check_field('set','contact_information')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="联系方式" prop="contact_information">
												<el-input id="contact_information" v-model="form['contact_information']" placeholder="请输入联系方式"
							  v-if="user_group === '管理员' || (form['rescue_contact_information_id'] && $check_field('set','contact_information')) || (!form['rescue_contact_information_id'] && $check_field('add','contact_information'))" :disabled="disabledObj['contact_information_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','contact_information')">{{form['contact_information']}}</div>
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
				field: "rescue_contact_information_id",
				url_add: "~/api/rescue_contact_information/add?",
				url_set: "~/api/rescue_contact_information/set?",
				url_get_obj: "~/api/rescue_contact_information/get_obj?",
				url_upload: "~/api/rescue_contact_information/upload?",

				query: {
					"rescue_contact_information_id": 0,
				},

				form: {
								"name_of_rescue_station":  '', // 救助站名称
										"position":  '', // 位置
										"animal_name":  '', // 动物名称
										"salvage_requirements":  '', // 救助要求
										"matters_needing_attention":  '', // 注意事项
										"contacts":  '', // 联系人
										"contact_information":  '', // 联系方式
											"rescue_contact_information_id": 0, // ID
					
				},
				disabledObj:{
								"name_of_rescue_station_isDisabled": false,
										"position_isDisabled": false,
										"animal_name_isDisabled": false,
										"salvage_requirements_isDisabled": false,
										"matters_needing_attention_isDisabled": false,
										"contacts_isDisabled": false,
										"contact_information_isDisabled": false,
										},

	
		
		
		
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
										
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
					bl = this.$check_action('/rescue_contact_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/rescue_contact_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/rescue_contact_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/rescue_contact_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/rescue_contact_information/view','get');
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
