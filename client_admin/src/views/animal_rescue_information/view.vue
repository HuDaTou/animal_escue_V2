<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','animal_no') || $check_field('add','animal_no') || $check_field('set','animal_no')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="动物编号" prop="animal_no">
												<el-input id="animal_no" v-model="form['animal_no']" placeholder="请输入动物编号"
							  v-if="user_group === '管理员' || (form['animal_rescue_information_id'] && $check_field('set','animal_no')) || (!form['animal_rescue_information_id'] && $check_field('add','animal_no'))" :disabled="disabledObj['animal_no_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','animal_no')">{{form['animal_no']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','animal_name') || $check_field('add','animal_name') || $check_field('set','animal_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="动物名称" prop="animal_name">
												<el-input id="animal_name" v-model="form['animal_name']" placeholder="请输入动物名称"
							  v-if="user_group === '管理员' || (form['animal_rescue_information_id'] && $check_field('set','animal_name')) || (!form['animal_rescue_information_id'] && $check_field('add','animal_name'))" :disabled="disabledObj['animal_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','animal_name')">{{form['animal_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','animal_category') || $check_field('add','animal_category') || $check_field('set','animal_category')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="动物类别" prop="animal_category">
								<el-select id="animal_category" v-model="form['animal_category']"
						v-if="user_group === '管理员' || (form['animal_rescue_information_id'] && $check_field('set','animal_category')) || (!form['animal_rescue_information_id'] && $check_field('add','animal_category'))">
						<el-option v-for="o in list_animal_category" :key="o['category_of_animal_rescue']" :label="o['category_of_animal_rescue']"
							:value="o['category_of_animal_rescue']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','animal_category')">{{form['animal_category']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','animal_sex') || $check_field('add','animal_sex') || $check_field('set','animal_sex')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="动物性别" prop="animal_sex">
								<el-select id="animal_sex" v-model="form['animal_sex']"
						v-if="user_group === '管理员' || (form['animal_rescue_information_id'] && $check_field('set','animal_sex')) || (!form['animal_rescue_information_id'] && $check_field('add','animal_sex'))">
						<el-option v-for="o in list_animal_sex" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','animal_sex')">{{form['animal_sex']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','age') || $check_field('add','age') || $check_field('set','age')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="年龄" prop="age">
												<el-input id="age" v-model="form['age']" placeholder="请输入年龄"
							  v-if="user_group === '管理员' || (form['animal_rescue_information_id'] && $check_field('set','age')) || (!form['animal_rescue_information_id'] && $check_field('add','age'))" :disabled="disabledObj['age_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','age')">{{form['age']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','photo') || $check_field('add','photo') || $check_field('set','photo')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="照片" prop="photo">
								<el-upload :disabled="disabledObj['photo_isDisabled']" id="photo" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_photo"
						:show-file-list="false" v-if="user_group === '管理员' || (form['animal_rescue_information_id'] && $check_field('set','photo')) || (!form['animal_rescue_information_id'] && $check_field('add','photo'))">
						<img v-if="form['photo']" :src="$fullUrl(form['photo'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','photo')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['photo'])" :preview-src-list="[$fullUrl(form['photo'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','vaccination') || $check_field('add','vaccination') || $check_field('set','vaccination')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="疫苗接种情况" prop="vaccination">
								<el-select id="vaccination" v-model="form['vaccination']"
						v-if="user_group === '管理员' || (form['animal_rescue_information_id'] && $check_field('set','vaccination')) || (!form['animal_rescue_information_id'] && $check_field('add','vaccination'))">
						<el-option v-for="o in list_vaccination" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','vaccination')">{{form['vaccination']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','details') || $check_field('add','details') || $check_field('set','details')" :xs="24" :sm="24" :lg="24" class="el_form_editor_warp">
				<el-form-item label="详情" prop="details">
					<quill-editor v-model.number="form['details']"
						v-if="user_group === '管理员' || (form['animal_rescue_information_id'] && $check_field('set','details')) || (!form['animal_rescue_information_id'] && $check_field('add','details')) ">
					</quill-editor>
					<div v-else-if="$check_field('get','details')" v-html="form['details']"></div>
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
				field: "animal_rescue_information_id",
				url_add: "~/api/animal_rescue_information/add?",
				url_set: "~/api/animal_rescue_information/set?",
				url_get_obj: "~/api/animal_rescue_information/get_obj?",
				url_upload: "~/api/animal_rescue_information/upload?",

				query: {
					"animal_rescue_information_id": 0,
				},

				form: {
								"animal_no":  '', // 动物编号
										"animal_name":  '', // 动物名称
										"animal_category":  '', // 动物类别
										"animal_sex":  '', // 动物性别
										"age":  '', // 年龄
										"photo":  '', // 照片
										"vaccination":  '', // 疫苗接种情况
										"details":  '', // 详情
											"animal_rescue_information_id": 0, // ID
					
				},
				disabledObj:{
								"animal_no_isDisabled": false,
										"animal_name_isDisabled": false,
										"animal_category_isDisabled": false,
										"animal_sex_isDisabled": false,
										"age_isDisabled": false,
										"photo_isDisabled": false,
										"vaccination_isDisabled": false,
										"details_isDisabled": false,
										},

	
		
						// 动物类别选项列表
				list_animal_category: [""],
	
						// 动物性别选项列表
				list_animal_sex: ['公','母'],
	
		
		
						// 疫苗接种情况选项列表
				list_vaccination: ['是','否'],
	
		
	
			}
		},
		methods: {


	
	
			
	
			
				/**
			 * 获取动物类别列表
			 */
			async get_list_animal_category() {
				var json = await this.$get("~/api/classification_of_rescue_animals/get_list?");
				if(json.result && json.result.list){
					this.list_animal_category = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
			
	
			
	
						/**
			 * 上传照片
			 * @param {Object} param 图片参数
			 */
			upload_photo(param){
						this.uploadFile(param.file, "photo");
					},
	
	
			
	
			
	
		
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
					bl = this.$check_action('/animal_rescue_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/animal_rescue_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/animal_rescue_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/animal_rescue_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/animal_rescue_information/view','get');
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
								this.get_list_animal_category();
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
